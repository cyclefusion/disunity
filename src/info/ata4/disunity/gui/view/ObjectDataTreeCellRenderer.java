/*
 ** 2014 December 22
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.disunity.gui.view;

import info.ata4.unity.rtti.ObjectData;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class ObjectDataTreeCellRenderer implements DelegateTreeCellRenderer<ObjectData> {
    
    private final Map<ObjectData, String> textCache = new HashMap<>();
    
    @Override
    public Class<ObjectData> getTreeCellType() {
        return ObjectData.class;
    }

    @Override
    public void configureTreeCellRenderer(DefaultTreeCellRenderer renderer,
            ObjectData userData, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        // getName() is expensive, cache it
        if (!textCache.containsKey(userData)) {
            textCache.put(userData, userData.getName());
        }
        
        renderer.setText(textCache.get(userData));
    }

}
