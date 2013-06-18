package com.cs.helper;

import com.cs.model.consulta.cep.RetornoCep;
import com.thoughtworks.xstream.XStream;
import java.io.InputStream;

public class CepHelper {

    

    public  RetornoCep findCEP(String cep) {
        XStream x = new XStream();
        try {
            java.net.URL mandarMail = new java.net.URL("http://republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            java.net.URLConnection conn = mandarMail.openConnection();
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
            httpConn.connect();
            InputStream is = httpConn.getInputStream();
            // FileInputStream input = new FileInputStream(x);
            // informa o nome do nó raiz do xml
            x.alias("webservicecep", RetornoCep.class);
            // cria um objeto de Pessoa,
            // contendo os dados lidos no xml
            RetornoCep logradouro = (RetornoCep) x.fromXML(is);

            return logradouro;

        } catch (java.net.MalformedURLException urlmal) {
            System.out.println(" erro busca cep");
        } catch (java.io.IOException ioexcp) {
            System.out.println(" erro busca cep 1");
        }

        return null;
    }

 }
