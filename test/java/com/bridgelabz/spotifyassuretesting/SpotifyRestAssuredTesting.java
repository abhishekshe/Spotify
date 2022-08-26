package com.bridgelabz.spotifyassuretesting;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class SpotifyRestAssuredTesting {
    public String token = "Bearer BQDCwRG-x-k9NiX4IBLNSvpzx5zwzhFjV9ZXUBpRZhHSnA2MYzQF94NcgOoiRgdqsZ_RbXxShpgMoTaubIkalWbx5SFlsJBjJAa2WLtgvPz0vOQnNxQ9skOsGYwe55tCmuKw8fhKkSWyPJW-vPcHKloArU77p_j7XbI6btXXkLtEBl-ryHSOOrRKDl1rsvEd05p4hYzHJRGHiv-0tq1fJGN9BeBSptfIRoGmUEj9yLWDmG0p8QnT6IjklKzK3AUiGZtF6dQZRUGu57rg";
    public String userId = "31onqp7xlsjfnpekhdtxlqvqsfvi";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }

    @Test(priority = 1)
    public void aGetCurrentUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 1)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        System.out.println("Current user's profile:" + userId);
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void bGetUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 2)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://open.spotify.com/user/31onqp7xlsjfnpekhdtxlqvqsfvi");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 3)
    public void createPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"New Hindi Songs\",\n" +
                        "  \"description\": \"New playlist Hindi Songs\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .queryParam("position", 3)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .post("https://api.spotify.com/v1/users/31onqp7xlsjfnpekhdtxlqvqsfvi/playlists");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test(priority = 4)
    public void daddItemsToPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 4)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/playlists/0xDRQnZox4mAjLdra2B8Mv/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 5)
    public void egetusersPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 5)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/users/31onqp7xlsjfnpekhdtxlqvqsfvi/playlists?limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 6)
    public void fgetPlaylistItems() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 6)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 7)
    public void gGetTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 7)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 8)
    public void hgetSeveralTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 8)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/tracks?market=ES&ids=6sFIWsNpZYqfjUpaCgueju");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }



    @Test(priority = 9)
    public void igetShow() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .queryParam("position", 9)
                .queryParam("uris", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M")
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }


}









