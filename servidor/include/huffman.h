#define MAX 16	//MAXimum length of codeword, more the MAX more overhead
#include<stdio.h>
#include<malloc.h>
#include<string.h>
#include <string>

#define INTERNAL 1
#define LEAF 0
char padding;
unsigned char N;

typedef struct symCode
{ char x;
    char code[MAX];
}symCode;

char ext[]=".hzip";
char dext[]=".txt";

symCode *symlist;
int n;
char *decodeBuffer(char buffer);
char *int2string(int n);
int match(char a[],char b[],int limit);
int fileError(FILE *fp);

typedef struct node
{
    char x;
    int freq;
    char *code;
    int type;
    struct node *next;
    struct node *left;
    struct node *right;
}node;

node *HEAD,*ROOT;

class huffman{

    node* newNode(char c)
    {
        node *q;
        q=(node *)malloc(sizeof(node));
        q->x=c;
        q->type=LEAF;	//leafnode
        q->freq=1;
        q->next=NULL;
        q->left=NULL;
        q->right=NULL;
        return q;
    }


    void printll()
    {
        node *p;
        p=HEAD;

        while(p!=NULL)
        {
            printf("[%c|%d]=>",p->x,p->freq);
            p=p->next;
        }
    }

public:
    int compress()
    {
        FILE *fp,*fp2;
        char ch;
        int t;
        HEAD=NULL;
        ROOT=NULL;
        fp=fopen("../Search.xml","rb");
        if(fp==NULL)
        {
            printf("[!]Input file cannot be opened.\n");
            return -1;
        }

        printf("\n[Pass1]");
        while(fread(&ch,sizeof(char),1,fp)!=0)
            addSymbol(ch);
        fclose(fp);

        printf("\nConstructing Huffman-Tree..");
        makeTree();
        printf("\nAssigning Codewords.\n");
        genCode(ROOT,"\0");	//preorder traversal

        printf("\n[Pass2]");
        fp=fopen("../Search.xml","r");
        if(fp==NULL)
        {
            printf("\n[!]Input file cannot be opened.\n");
            return -1;
        }
        fp2=fopen("../dest.xml","wb");
        if(fp2==NULL)
        {
            printf("\n[!]Output file cannot be opened.\n");
            return -2;
        }
        printf("\nWriting File Header.");
        writeHeader(fp2);
        printf("\nWriting compressed content.");
        while(fread(&ch,sizeof(char),1,fp)!=0)
        {
            //printf("\n%c replaced with ",ch);
            writeCode(ch,fp2);	//write corresponding code into fp2
        }
        fclose(fp);
        fclose(fp2);

        printf("\nDone..\n");
        return 0;
    }

    void writeHeader(FILE *f)
    {//Table mapping 'codewords' to actual symbols
        symCode record;
        node *p;
        int temp=0,i=0;
        p=HEAD;
        while(p!=NULL)	//determine number of unique symbols and padding of bits
        {
            temp+=(strlen(p->code)) * (p->freq);		//temp stores padding
            if(strlen(p->code) > MAX) printf("\n[!] Codewords are longer than usual.");	//TODO: Solve this case
            temp%=8;
            i++;
            p=p->next;
        }

        if(i==256)
            N=0;	//if 256 diff bit combinations exist, then alias 256 as 0
        else
            N=i;

        fwrite(&N,sizeof(unsigned char),1,f);	//read these many structures while reading
        printf("\nN=%u",i);

        p=HEAD;
        while(p!=NULL)	//start from HEAD, write each char & its code
        {
            record.x=p->x;
            strcpy(record.code,p->code);
            fwrite(&record,sizeof(symCode),1,f);
//	printf("\n%c|%s",record.x,record.code);
            p=p->next;
        }
//discard 'padding' bits before data, while reading
        padding=8-(char)temp;	//int to char & padding = 8-bitsExtra
        fwrite(&padding,sizeof(char),1,f);
        printf("\nPadding=%d",padding);
//do actual padding
        for(i=0;i<padding;i++)
            writeBit(0,f);

    }//fun

    void writeCode(char ch,FILE *f)
    {
        char *code;
        code=getCode(ch);
//printf("\n%s\n",code);
        while(*code!='\0')
        {
            if(*code=='1')
                writeBit(1,f); //write bit 1 into file f
            else
                writeBit(0,f);
            code++;
        }
        return;
    }

    void writeBit(int b,FILE *f)
    {//My Logic: Maintain static buffer, if it is full, write into file
        static char byte;
        static int cnt;
        char temp;
        //printf("\nSetting %dth bit = %d of %d ",cnt,b,byte);
        if(b==1)
        {	temp=1;
            temp=temp<<(7-cnt);		//right shift bits
            byte=byte | temp;
        }
        cnt++;

        if(cnt==8)	//buffer full
        {
//		printf("[%s]",bitsInChar(byte));
            fwrite(&byte,sizeof(char),1,f);
            cnt=0; byte=0;	//reset buffer
            return;// buffer written to file
        }
        return;
    }

    char *getCode(char ch)
    {
        node *p=HEAD;
        while(p!=NULL)
        {
            if(p->x==ch)
                return p->code;
            p=p->next;
        }
        return NULL; //not found
    }

    void insert(node *p,node *m)
    { // insert p in list as per its freq., start from m to right,
// we cant place node smaller than m since we dont have ptr to node left to m
        if(m->next==NULL)
        {  m->next=p; return;}
        while(m->next->freq < p->freq)
        {  m=m->next;
            if(m->next==NULL)
            { m->next=p; return; }
        }
        p->next=m->next;
        m->next=p;
    }

    void addSymbol(char c)
    {// Insert symbols into linked list if its new, otherwise freq++
        node *p,*q,*m;
        int t;

        if(HEAD==NULL)
        {	HEAD=newNode(c);
            return;
        }
        p=HEAD; q=NULL;
        if(p->x==c) //item found in HEAD
        {
            p->freq+=1;
            if(p->next==NULL)
                return;
            if(p->freq > p->next->freq)
            {
                HEAD=p->next;
                p->next=NULL;
                insert(p,HEAD);
            }
            return;
        }

        while(p->next!=NULL && p->x!=c)
        {
            q=p; p=p->next;
        }

        if(p->x==c)
        {
            p->freq+=1;
            if(p->next==NULL)
                return;
            if(p->freq > p->next->freq)
            {
                m=p->next;
                q->next=p->next;
                p->next=NULL;
                insert(p,HEAD);
            }
        }
        else  //p->next==NULL , all list traversed c is not found, insert it at beginning
        {
            q=newNode(c);
            q->next=HEAD;  //first because freq is minimum
            HEAD=q;
        }
    }

    void makeTree()
    {
        node  *p,*q;
        p=HEAD;
        while(p!=NULL)
        {
            q=newNode('@');
            q->type=INTERNAL;	//internal node
            q->left=p;		//join left subtree/node
            q->freq=p->freq;
            if(p->next!=NULL)
            {
                p=p->next;
                q->right=p;	//join right subtree /node
                q->freq+=p->freq;
            }
            p=p->next;	//consider next node frm list
            if(p==NULL)	//list ends
                break;
            //insert new subtree rooted at q into list starting from p
            //if q smaller than p
            if(q->freq <= p->freq)
            {//place it before p
                q->next=p;
                p=q;
            }
            else
                insert(q,p);	//find appropriate position
        }//while
        ROOT=q; //q created at last iteration is ROOT of h-tree
    }

    void genCode(node *p,char* code)
    {
        char *lcode,*rcode;
        static node *s;
        static int flag;
        if(p!=NULL)
        {
//sort linked list as it was
            if(p->type==LEAF)   //leaf node
            {	if(flag==0) //first leaf node
                {flag=1; HEAD=p;}
                else	//other leaf nodes
                { s->next=p;}		//sorting LL
                p->next=NULL;
                s=p;
            }

//assign code
            p->code=code;	//assign code to current node
//	printf("[%c|%d|%s|%d]",p->x,p->freq,p->code,p->type);
            lcode=(char *)malloc(strlen(code)+2);
            rcode=(char *)malloc(strlen(code)+2);
            sprintf(lcode,"%s0",code);
            sprintf(rcode,"%s1",code);
//recursive DFS
            genCode(p->left,lcode);		//left child has 0 appended to current node's code
            genCode(p->right,rcode);
        }
    }

    int decompress(std::string source, std::string dest)
    {
        FILE *fp,*outfile;
        char buffer;
        char *decoded;
        int i;

        if((fp=fopen(source.c_str(),"rb"))==NULL)
        {
            printf("[!]Input file cannot be opened.\n");
            return -1;
        }

        printf("\n[Reading File Header]");
        if(fread(&buffer,sizeof(unsigned char),1,fp)==0) return (fileError(fp));
        N=buffer;		//No. of structures(mapping table records) to read
        if(N==0)
            n=256;
        else
            n=N;
        printf("\nDetected: %u different characters.",n);

//allocate memory for mapping table
        symlist=(symCode *)malloc(sizeof(symCode)*n);

        printf("\nReading character to Codeword Mapping Table");
        if(fread(symlist,sizeof(symCode),n,fp)==0) return (fileError(fp));
        //Read mapping table
/*
printf("\n");
for(i=0;i<n;i++)
	printf("[%c|%s] ",symlist[i].x,symlist[i].code);
*/

        if(fread(&buffer,sizeof(char),1,fp)==0) return (fileError(fp));
        padding=buffer;		//No. of bits to discard
        printf("\nDetected: %u bit padding.",padding);

        if((outfile=fopen(dest.c_str(),"wb"))==NULL)
        {
            printf("[!]Output file cannot be opened.\n");
            fclose(fp);
            return -2;
        }

        printf("\n\n[Reading data]\nReplacing codewords with actual characters");
        while(fread(&buffer,sizeof(char),1,fp)!=0)	//Read 1 byte at a time
        {
            decoded=decodeBuffer(buffer);	//decoded is pointer to array of characters read from buffer byte
            i=0;
            while(decoded[i++]!='\0');	//i-1 characters read into decoded array
            //printf("%s",decoded);
            fwrite(decoded,sizeof(char),i-1,outfile);
        }
        fclose(fp);
        fclose(outfile);
        return 0;
    }

    char *decodeBuffer(char b)
    {
        int i=0,j=0,t;
        static int k;
        static int buffer;	// buffer larger enough to hold two b's
        char *decoded=(char *)malloc(MAX*sizeof(char));
/*
Logic:
buffer = [1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0]
		k
   b   =        [ 1 0 1 1 0 0 1 1 ]
//put b in integer t right shift k+1 times then '&' with buffer; k=k+8;
buffer = [1 0 0 1 1 0 1 1 0 0 1 1 0 0 0 0]
				k
*/

        t=(int)b;
//printf("\nt=%sk=%d",int2string(t),k);
        t=t & 0x00FF;		//mask high byte
//printf("\nt=%sk=%d",int2string(t),k);
        t=t<<8-k;		//shift bits keeping zeroes for old buffer
//printf("\nt=%sk=%d",int2string(t),k);
        buffer=buffer | t;	//joined b to buffer
        k=k+8;			//first useless bit index +8 , new byte added

        if(padding!=0)	// on first call
        {buffer=buffer<<padding;
            k=8-padding;	//k points to first useless bit index
            padding=0;}

//printf("\nbuffer=%s, k=%d",int2string(buffer),k);
//loop to find matching codewords

        while(i<n)
        {
            if(!match(symlist[i].code, int2string(buffer),k))
            {
                decoded[j++]=symlist[i].x;	//match found inserted decoded
                t=strlen(symlist[i].code);	//matched bits
                buffer=buffer<<t;		//throw out matched bits
                k=k-t;				//k will be less
                i=0;				//match from initial record
                //printf("\nBuffer=%s,removed=%c,k=%d",int2string(buffer),decoded[j-1],k);
                if(k==0) break;
                continue;
            }
            i++;
        }

        decoded[j]='\0';
        return decoded;

    }//fun

    int match(char a[],char b[],int limit)
    {
        b[strlen(a)]='\0';
        b[limit]='\0';
        return strcmp(a,b);
    }

    char *int2string(int n)
    {
        int i,k,an,j;
        char *temp=(char *)malloc(16*sizeof(char));
        j=0;

        for(i=15;i>=0;i--)
        {
            an=1<<i;
            k=n & an;
            if(k==0) temp[j++]='0'; else temp[j++]='1';
        }
        temp[j]='\0';
        return temp;
    }

    int fileError(FILE *fp)
    {
        printf("[!]File read Error.\n[ ]File is not compressed using huffman.\n");
        fclose(fp);
        return -3;
    }

};