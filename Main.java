import java.util.Scanner;
import java.text.DecimalFormat;
class Main {
  public static void main(String[] args) {
    double[] salarios = new double[5];
    Scanner scan = new Scanner(System.in);

    for (int i = 0; i<5; i++){
      System.out.println("Digite o salario do "+(i+1)+"° funcionario");
      salarios[i] = scan.nextDouble();
    }
    System.out.println("-----------------------------------------------------------------------");
    calculoSalario(salarios);
  }
  public static void calculoSalario(double[] input){
    double descontos = 0;
    double inss = 0;
    double IR = 0;

    for (int i = 0; i< input.length; i++){
      if (input[i] <= 1212.00){
        inss = 0.075 * input[i];
      }else if(1212.01 <= input[i] && input[i]<= 2427.35){
        inss = 0.09 * input[i];
      }else if(2427.36 <= input[i] && input[i]<= 3641.03){
        inss = 0.12 * input[i];
      }else if (3641.04 <= input[i]){
        inss = 0.14 * input[i];
      }

      if(input[i]> 1903.98 && input[i]<=2826.65){
        IR = 0.075 * input[i];
      }else if(input[i]>= 2826.66 && input[i]<=3751.05){
        IR = 0.15 * input[i];
      }else if(input[i]>= 3751.06 && input[i]<=4664.68){
        IR = 0.225 * input[i];
      }else if (4664.68 < input[i]){
        IR = 0.275 * input[i];
      }
      descontos = IR + inss;

      System.out.println(
        "Folha de pagamento do "+ (i+1)+"° Funcionario\n"+
        "INSS: "+ new DecimalFormat("#,##0.00").format(inss) + 
        "\nImposto de renda: " + new DecimalFormat("#,##0.00").format(IR)  + 
        "\nSalario Bruto: "+ new DecimalFormat("#,##0.00").format(input[i]) + 
        "\nSalario Liquido: "+ new DecimalFormat("#,##0.00").format((input[i] - descontos))
      );
      System.out.println("-----------------------------------------------------------------------");
    }
  }
}