/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "IndexedErrorCollector.java ".  Description:
 "Error Collector tracking a test index"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2;

import java.util.concurrent.Callable;

import org.hamcrest.Matcher;
import org.junit.rules.ErrorCollector;
import static org.junit.Assert.assertThat;


public class IndexedErrorCollector extends ErrorCollector {

    private class TestException extends Exception {

        TestException(int i, Throwable cause) {
            super("Test " + i + " failed.", cause);
        }
    }
    /**
     * Adds a Throwable to the table.  Execution continues, but the test will fail at the end.
     */
    public void addError(int i, Throwable error) {
        addError(new TestException(i, error));
    }

    /**
     * Adds a failure to the table if {@code matcher} does not match {@code value}.
     * Execution continues, but the test will fail at the end if the match fails.
     */
    public <T> void checkThat(int i, final T value, final Matcher<T> matcher) {
        checkSucceeds(i, new Callable<Object>() {
            public Object call() throws Exception {
                assertThat(value, matcher);
                return value;
            }
        });
    }

    /**
     * Adds to the table the exception, if any, thrown from {@code callable}.
     * Execution continues, but the test will fail at the end if {@code callable}
     * threw an exception.
     */
    public Object checkSucceeds(int i, Callable<Object> callable) {
        try {
            return callable.call();
        } catch (Throwable e) {
            addError(i, e);
            return null;
        }
    }
}
