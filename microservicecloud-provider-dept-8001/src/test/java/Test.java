import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String sqlPre = "insert into icsp_info_cata(cata, cataname, prodcata, prodcataname, codedesc, codesrc) values (";
        String sqlSuf = ", '第一财经', '06');";
        try {
            List<String> strings = FileUtils.readLines(new File("E:\\code.txt"), "utf-8");
            strings.stream()
                    .map(code -> StringUtils.collectionToDelimitedString(Arrays.asList(code.split("\t")), ",", "'", "'"))
                    .map(value -> sqlPre + value + sqlSuf).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
