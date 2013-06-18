package com.cs.helper;

public class ValidaCpfCnpj {

    private final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private boolean validCPF = false;
    private boolean validCNPF = false;

    private int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public boolean getValidCPF() {
        return validCPF;
    }

    public boolean getValidCNPF() {
        return validCNPF;
    }

    public boolean setValidCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");

        if ((cpf == null) || (cpf.length() != 11) || cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            validCPF = false;
            //FacesContext ctx = FacesContext.getCurrentInstance();
            // ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido!!!", ""));
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        if (!cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString())) {
            validCPF = false;
            //FacesContext ctx = FacesContext.getCurrentInstance();
            //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido!!!", ""));
            return validCPF;
        }
        return validCPF = true;
    }

    public boolean setValidCNPJ(String cnpj) {
        cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");

        if ((cnpj == null) || (cnpj.length() != 14) || cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            validCNPF = false;
            //FacesContext ctx = FacesContext.getCurrentInstance();
            //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ Inválido!!!", ""));
            return validCNPF;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        if (!cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString())) {
            validCNPF = false;
            //FacesContext ctx = FacesContext.getCurrentInstance();
            //ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ Inválido!!!", ""));
            return validCNPF;
        }
        return validCNPF = true;
    }
    /*
     public static void main(String[] args) {
     ValidaCpfCnpj v = new ValidaCpfCnpj();
     System.out.printf("CPF Valido:%s \n", v.isValidCPF("95018593391"));
     System.out.printf("CNPJ Valido:%s \n", v.isValidCNPJ("78064837000191"));
     }*/
}
