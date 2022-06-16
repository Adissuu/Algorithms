public class MyHashMap extends AbsHashMap {

    public class Entry {
        private int key;
        private String value;

        public Entry(String v) {
            key = (int) (Math.random());
            value = v;
        }
    }

    public MyHashMap(int c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String get(int key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String put(int k, String v) {

        this.size();// number of element
        return null;
    }

    @Override
    public String remove(int k) {
        // TODO Auto-generated method stub
        return null;
    }

}
