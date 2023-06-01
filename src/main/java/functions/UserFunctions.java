package functions;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class UserFunctions {


    @Step("Send POST request to /api/auth/register for create user")
    public void sendPostRequestCreateUser(DataUser dataUser) {
        given()
                .header("Content-type", "application/json")
                .body(dataUser).post("/api/auth/register");
    }

    @Step("Send POST request to /api/auth/login for get token user")
    public String getAccessToken(DataUser dataUser) {
        return given()
                .header("Content-type", "application/json")
                .body(dataUser)
                .post("/api/auth/login")
                .then().extract().body().path("accessToken");
    }

    @Step("Send DELETE request to /api/auth/user for delete user")
    public void sendDeleteRequestDeleteUser(DataUser dataUser) {
        if (getAccessToken(dataUser) != null) {
            given().header("Authorization", getAccessToken(dataUser))
                    .delete("/api/auth/user");
        }
    }
}