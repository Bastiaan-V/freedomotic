/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.freedomotic.plugins;

import it.freedomotic.api.Actuator;
import it.freedomotic.app.Freedomotic;
import it.freedomotic.exceptions.UnableToExecuteException;
import it.freedomotic.objects.EnvObjectLogic;
import it.freedomotic.persistence.CommandPersistence;
import it.freedomotic.plugins.gui.LogWindowHandler;
import it.freedomotic.reactions.Command;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author Enrico
 */
public class LogViewer extends Actuator {

    private LogWindowHandler handler = null;
    private Logger logger = null;

    public LogViewer() {
        super("Log Viewer", "/it.nicoletti.test/logviewer-manifest.xml");

    }

    @Override
    protected void onShowGui() {
        handler = LogWindowHandler.getInstance();
        handler.setLevel(Level.INFO);
        handler.setFilter(new Filter() {

            public boolean isLoggable(LogRecord record) {
                //logs every message
                return true;
            }
        });
        logger = Freedomotic.logger;
        logger.addHandler(handler);
        bindGuiToPlugin(handler.window);
    }

    @Override
    protected void onStart() {
        showGui();
    }

    @Override
    protected void onCommand(Command c) throws IOException, UnableToExecuteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean canExecute(Command c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
