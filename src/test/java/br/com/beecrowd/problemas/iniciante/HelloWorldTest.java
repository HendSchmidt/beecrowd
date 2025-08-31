package br.com.beecrowd.problemas.iniciante;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Hello world")
public class HelloWorldTest {
	private static final String HELLO_WORD_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.HelloWorldArrange";

	@ParameterizedTest(name = "Arrange {index}:")
	@MethodSource({HELLO_WORD_ARRANGE + "#mensagemCorreta"})
	@DisplayName("Deve retornar a mensagem correta.")
	void deveRetornarMensagemCorreta(String esperado){
		HelloWorld test = new HelloWorld();

		String retornado = test.message();

		assertAll("Mensagem",
				() -> assertEquals(esperado, retornado, "À mensagem retornada deve ser igual."));
	}
}
