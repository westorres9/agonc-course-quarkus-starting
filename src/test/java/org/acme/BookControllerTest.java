package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookControllerTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/books")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("size()", is(4));
    }

    @Test
    public void shouldCountAllBooks() {
        given()
        .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when()
                .get("/books/count")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("4"));
    }

    @Test
    public void shouldGetAllBook() {
        given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/books/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio Goncalves"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("IT"));
    }
}
