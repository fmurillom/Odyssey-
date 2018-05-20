//
// Created by fmurillom on 10/05/18.
//

#ifndef LIVE555_SONG_H
#define LIVE555_SONG_H

#include <iostream>

using namespace std;


/*!
 * Clase utilizada para representar todo lo que tenga que ver con una cancion
 */
class Song{
private:
    string name;
    string artist;
    string album;
    string rating;
    string lyrics;
    string genre;
    string filename;
    string streamAdress;

public:
    const string &getName() const {
        return name;
    }

    Song(){}

    /*!
     * metodo constructor para la clase
     * @param name nombre de la cancion
     * @param artist nombre del artista
     * @param rating rating de la cancion
     * @param lyrics letra de la cancion
     * @param genre genero de la cancion
     * @param filename path del archivo
     * @param album album de la cancion
     */
    Song(const string &name, const string &artist,const string &rating, const string &lyrics, const string &genre,
         const string &filename,const string &album) : name(name), artist(artist), rating(rating), lyrics(lyrics), genre(genre), filename(filename), album(album) {}

    void setName(const string &name) {
        Song::name = name;
    }

    void setAlbum(string album){
        Song::album = album;
    }

    const string &getAlbum(){
        return album;
    }

    const string &getArtist() const {
        return artist;
    }

    void setArtist(const string &artist) {
        Song::artist = artist;
    }

    string getRating() const {
        return rating;
    }

    void setRating(string rating) {
        Song::rating = rating;
    }

    const string &getLyrics() const {
        return lyrics;
    }

    void setLyrics(const string &lyrics) {
        Song::lyrics = lyrics;
    }

    const string &getGenre() const {
        return genre;
    }

    void setGenre(const string &genre) {
        Song::genre = genre;
    }

    const string &getFilename() const {
        return filename;
    }

    void setFilename(const string &filename) {
        Song::filename = filename;
    }

    const string &getStreamAdress() const {
        return streamAdress;
    }

    void setStreamAdress(const string &streamAdress) {
        Song::streamAdress = streamAdress;
    }

    bool operator==(const Song &rhs) const {
        return name == rhs.name || artist == rhs.artist || album == rhs.album;
    }

    bool operator!=(const Song &rhs) const {
        return !(rhs == *this);
    }

    friend ostream &operator<<(ostream &os, const Song &song) {
        os << "name: " << song.name << " artist: " << song.artist << " rating: " << song.rating << " lyrics: "
           << song.lyrics << " genre: " << song.genre << " adress: " << song.getStreamAdress();
        return os;
    }

};

#endif //LIVE555_SONG_H
