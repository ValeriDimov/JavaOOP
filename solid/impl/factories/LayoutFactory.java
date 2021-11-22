package solid.impl.factories;

import solid.impl.layouts.SimpleLayout;
import solid.impl.layouts.XmlLayout;
import solid.interfaces.Factory;
import solid.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }

        return layout;
    }
}
