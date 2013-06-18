package com.cs.converters;

import java.text.ParseException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FacesConverter("cnpjConverter")
public class CNPJConverter implements Converter {

    Logger log = LogManager.getLogger(CNPJConverter.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        MaskFormatter mf;

        try {
            if (o.toString().length() == 14) {
                mf = new MaskFormatter("##.###.###/####-##");
            } else {
                mf = new MaskFormatter("###.###.###-##");
            }

            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(o.toString());
        } catch (ParseException ex) {
            log.error("Erro ao converter CNPJ", ex);
            return "";
        }
    }
}
