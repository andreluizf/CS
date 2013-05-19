package com.web.sistema;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class LoginErrorPhaseListener implements PhaseListener {

    Logger logger = LogManager.getLogger(LoginErrorPhaseListener.class.getName());
    private static final long serialVersionUID = -1216620620302322995L;

    @Override
    public void afterPhase(final PhaseEvent arg0) {
//        arg0.getFacesContext().getExternalContext();
//        System.out.println("AFTER: " + arg0.getPhaseId());
    }

    @Override
    public void beforePhase(final PhaseEvent arg0) {
//        arg0.getFacesContext().getExternalContext();
//
//        System.out.println("BEFORE: " + arg0.getPhaseId());

        Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
                AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);
        if (e instanceof BadCredentialsException) {
            logger.entry();
            logger.error("Usuario Errado: " + e.getMessage());
            logger.exit();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY, null);
            FacesUtils.addErrorMessage("Username or password not valid.");
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
