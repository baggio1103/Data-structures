import org.junit.Test;

import static org.junit.Assert.*;

public class NativeDictionaryTest {

    @Test
    public void isKey() {
        NativeDictionary my_dict = new NativeDictionary(7, String.class);
        String [] keys = {"hate", "contempt","loss","enmity","grief","fear","defeat"};
        String [] value = {"love","respect", "victory","friendship","happiness","courage","success"};
        for (int i = 0; i < my_dict.size; i++){
            my_dict.put(keys[i],value[i]);
        }
        assertEquals(true, my_dict.isKey("contempt"));
        assertEquals(false, my_dict.isKey("happiness"));
    }

    @Test
    public void put() {
        NativeDictionary my_dict = new NativeDictionary(7, String.class);
        String [] keys = {"hate", "contempt","loss","enmity","grief","fear","defeat"};
        String [] value = {"love","respect", "victory","friendship","happiness","courage","success"};
        for (int i = 0; i < my_dict.size; i++){
            my_dict.put(keys[i],value[i]);
        }

    }

    @Test
    public void get() {
        NativeDictionary my_dict = new NativeDictionary(7, String.class);
        String [] keys = {"hate", "contempt","loss","enmity","grief","fear","defeat"};
        String [] value = {"love","respect", "victory","friendship","happiness","courage","success"};
        for (int i = 0; i < my_dict.size; i++){
            my_dict.put(keys[i],value[i]);
        }
        assertEquals("love",my_dict.get("hate"));
        assertEquals(null, my_dict.get("sun"));
        assertEquals("friendship", my_dict.get("enmity"));
    }
}
