package ca.uhn.hl7v2.testpanel.ui.editor;

import javax.swing.text.DefaultCaret;

public class EditorCaret extends DefaultCaret {

	/**
     * {@inheritDoc}
     */
    
    @Override
    public void setSelectionVisible(boolean theVis) {
	    super.setSelectionVisible(true);
    }

	
	
}
