package ludo.logic;

import java.util.ArrayList;

public class CircularList<E> extends ArrayList<E> {

        @Override
        public E get(int index) {
            return super.get(index % size());
        }

}
