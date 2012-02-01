/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uhn.hl7v2.testpanel.ui;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author James
 */
public class ImageFactory{
    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static Map<String, ImageIcon> ourIcons = new HashMap<String, ImageIcon>(  );

    //~ Methods --------------------------------------------------------------------------------------------------------

    public static ImageIcon getButtonExecute(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/button_execute.png" );
    }

    public static ImageIcon getFile(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/file.png" );
    }

    public static ImageIcon getTable(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/table.png" );
    }

    private static ImageIcon getImageIcon( String theLocation ){
        ImageIcon retVal = ourIcons.get( theLocation );

        if ( retVal == null ){
            URL resource = ImageFactory.class.getClassLoader().getResource( theLocation );
			if (resource == null) {
				throw new Error(theLocation);
			}
			retVal = new ImageIcon( resource );
			ourIcons.put( theLocation, retVal );
        }

        return retVal;
    }

    public static ImageIcon getInterfaceOff(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/interface_off.png" );
    }

    public static ImageIcon getHapi64(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/hapi_64.png" );
    }

    public static ImageIcon getInterfaceOn(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/interface_on.png" );
    }

    public static Icon getInterfaceStarting() {
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/interface_starting.png" );
	}

    public static ImageIcon getMessageHl7(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/message_hl7.png" );
    }

    public static ImageIcon getMessageIn(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/message_in.png" );
    }

    public static ImageIcon getMessageOut(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/message_out.png" );
    }

    public static ImageIcon getMessageXml(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/message_xml.png" );
    }

    public static ImageIcon getTabLog(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/tab_log.png" );
    }

    public static ImageIcon getTest(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/test.png" );
    }

    public static ImageIcon getTestFailed(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/test_failed.png" );
    }

    public static ImageIcon getTestPassed(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/test_passed.png" );
    }

    public static ImageIcon getTestRunning(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/test_running.png" );
    }

    public static ImageIcon getTreeBundle(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/tree_bundle.png" );
    }

    public static ImageIcon getTreeLeaf(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/tree_leaf.png" );
    }

    public static ImageIcon getValFailed(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/val_failed.png" );
    }

	public static Icon getValFailedChild() {
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/val_failed_child.png" );
	}

	public static ImageIcon getValPassed(  ){
        return getImageIcon( "ca/uhn/hl7v2/testpanel/images/val_passed.png" );
    }
}
