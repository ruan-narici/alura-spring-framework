package praticando;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/responsePage2")
public class responsePage1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		PrintWriter escrevaAResposta = resp.getWriter();
		escrevaAResposta.print("""
				<html>
					<head>
						<meta charset="UTF-8">
						<title>Sucesso!</title>
					</head>
					<body>
						<h1>Seja bem-vindo ao responsePage1</h1>
						<h3>Seu Servlet está funcionando perfeitamente!</h3>
					</body>
				</html>
				""");
		System.out.println("A class responsePage1 foi chamada.");
	}
}
