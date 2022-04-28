import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Qual a quantidade de atletas? ");
		int N = sc.nextInt();

		while (N <= 0) {
			System.out.print("Valor inválido! Favor digitar um valor positivo: ");
			N = sc.nextInt();
		}

		String nome, atletaMaisAlto = "";
		int contM = 0, contF = 0;
		double altura, peso, mediaPesoAtletas = 0, maiorAltura = 0, alturaMulheres = 0;
		char sexo;

		for (int i = 0; i < N; i++) {
			System.out.printf("Digite os dados do %do atleta: \n", i+1);
			System.out.print("Nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.print("Sexo: ");
			sexo = sc.nextLine().charAt(0);
			while (sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f') {
				System.out.print("Valor inválido, favor digitar F ou M: ");
				sexo = sc.nextLine().charAt(0);

			}

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.print("Valor inválido, favor digitar um valor positivo! ");
				altura = sc.nextDouble();
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.print("Valor inválido, favor digitar um número positivo! ");
				peso = sc.nextDouble();
			}

			if (maiorAltura < altura) {
				maiorAltura = altura;
				atletaMaisAlto = nome;
			}

			if (sexo == 'M' || sexo == 'm') {
				contM++;
			}

			if (sexo == 'F' || sexo == 'f') {
				contF++;
				alturaMulheres += altura;
			}

			mediaPesoAtletas += peso;

		}		
		
		double pesoMedio = mediaPesoAtletas / N;
		double porcentagemHomem = contM * 100 / N;
		double alturaMediaMulheres = alturaMulheres / contF;
		
		System.out.printf("\n\nRELATÓRIO:\n");
		System.out.printf("Peso médio dos atletas: %.2f\n", pesoMedio);
		System.out.printf("Atleta mais alto: %s\n", atletaMaisAlto);
		System.out.printf("Porcentagem de homens: %.2f %%\n", porcentagemHomem);
		if (contF == 0) {
			System.out.println("Não há mulheres cadastradas!\n");
		}else {
			System.out.printf("Altura média das Mulheres: %.2f ", alturaMediaMulheres);
		}

		sc.close();
	}

}
