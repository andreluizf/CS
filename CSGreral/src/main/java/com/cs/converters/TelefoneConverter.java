package com.cs.converters;

import java.text.ParseException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@FacesConverter(value = "telefoneConverter")
public class TelefoneConverter implements Converter {

    Logger log = LogManager.getLogger(TelefoneConverter.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        MaskFormatter mf;
        try {
            if (!("").equals(o.toString().trim())) {
                if (o.toString().length() == 11) {
                    mf = new MaskFormatter("(##)#####-####");
                } else {
                    mf = new MaskFormatter("(##)####-####");
                }
                mf.setValueContainsLiteralCharacters(false);
                return mf.valueToString(o.toString());
            }
            return "";
        } catch (ParseException ex) {
            log.error("Erro ao converter telefone", ex);
            return "";
        }
    }
}
