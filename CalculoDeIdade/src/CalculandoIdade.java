
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
	
@WebServlet(name="servletCalcula", urlPatterns="/calculadora")
public class CalculandoIdade extends HttpServlet{
	
		private static final long serialVersionUID = 1L;
		private int dia;
		private int mes;
		private int ano;
		private int idade;
		int mesDigitado = 0;
		int diaDigitado = 0; 
		int anoDigitado = 0;
		boolean anoBissexto;
		//Cria��o de vari�vel tipo LocalDate para calcular datas  melhor que a Calendar pois possibilita calculos de tempo
		private LocalDate anoAtual = LocalDate.now();
		
		@Override
		public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
				
			String dia = request.getParameter("dia");
			String mes = request.getParameter("mes");
			String ano = request.getParameter("ano");
			
			diaDigitado = Integer.parseInt(dia);
			mesDigitado = Integer.parseInt(mes);
			anoDigitado = Integer.parseInt(ano);
			anoBissexto = false;
			
			if((anoDigitado % 400 !=0) && (mesDigitado == 2 && diaDigitado > 29)) {
				
				anoBissexto = true;
			}
			if ((anoDigitado <= anoAtual.getYear()) && (diaDigitado <= 31) && (mesDigitado > 0) &&( mesDigitado <= 12 && anoBissexto == false) && (dia !="" && mes !="" && ano !="")) {
				

				//parse da data string para tipo LocalDate
				LocalDate aniversario = LocalDate.parse(ano+"-"+ mes+"-"+dia);
				
				//Cria��o de variavel idade tipo Period para calcular Periodos e o m�todo between faz o calculo entre as datas
				Period idade = Period.between(anoAtual, aniversario);
				
			
			// escreve o texto
			
				
			out.println("<html>");
			//adicionando cor a pagina html, alinhando ao centro e definindo o tamanho dos inputs
			out.println("<body style=\"background-color:grey;\">");
			out.println("<div align=\"center\">");
			out.println("A sua idade �: " + (idade.getYears())*-1);
			out.println("<br />");
			out.println("<br />");
			out.println("<input type='button' value='Voltar' onclick='history.go(-1)' />");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			
			}else if(mesDigitado <= 0 || mesDigitado > 12) { 
				//cria��o de valida��o quando n�o h� nenhum campo preenchido, *faltam mais valida��es
				out.println("<html>");
				out.println("<body style=\"background-color:grey;\">");
				out.println("<div align=\"center\">");
				out.println("M�s Inv�lido!");
				out.println("<br />");
				out.println("<br />");
				out.println("<input type='button' value='Voltar' onclick='history.go(-1)' />");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			
			}else if(mesDigitado == 2 && diaDigitado > 29 && anoBissexto) { 
				//cria��o de valida��o quando n�o h� nenhum campo preenchido, *faltam mais valida��es
				out.println("<html>");
				out.println("<body style=\"background-color:grey;\">");
				out.println("<div align=\"center\">");
				out.println("Dia Inv�lido, ano bissexto!");
				out.println("<br />");
				out.println("<br />");
				out.println("<input type='button' value='Voltar' onclick='history.go(-1)' />");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			
			} else if(diaDigitado > 31) { 
				//cria��o de valida��o quando n�o h� nenhum campo preenchido, *faltam mais valida��es
				out.println("<html>");
				out.println("<body style=\"background-color:grey;\">");
				out.println("<div align=\"center\">");
				out.println("Dia Inv�lido!");
				out.println("<br />");
				out.println("<br />");
				out.println("<input type='button' value='Voltar' onclick='history.go(-1)' />");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
			}else{ 
			//cria��o de valida��o quando n�o h� nenhum campo preenchido, *faltam mais valida��es
			out.println("<html>");
			out.println("<body style=\"background-color:grey;\">");
			out.println("<div align=\"center\">");
			out.println("Idade Inv�lida!");
			out.println("<br />");
			out.println("<br />");
			out.println("<input type='button' value='Voltar' onclick='history.go(-1)' />");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
		}
	}

