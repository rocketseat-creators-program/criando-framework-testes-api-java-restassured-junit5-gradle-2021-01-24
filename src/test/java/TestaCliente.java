import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TestaCliente {

    String enderecoAPI = "https://tester-global-cliente-api.herokuapp.com/";

    @Test
    @DisplayName("Quando eu pegar a lista de todos os clientes, entao deve contar Expert Club")
    public void verificaClienteLista() {

        String nomeEsperado = "Experts Club";

        given()
                .contentType(ContentType.JSON)
        .when()
                .get(enderecoAPI)

        .then()
                .statusCode(200)
                .assertThat().body(containsString(nomeEsperado));
    }
}
