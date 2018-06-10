package com.yeta.tophistory.parser;

import com.yeta.tophistory.domain.HistoryRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserCompilerTest {

    String className = "RottenTomatoesParserDouble";
    String rottenTomatoesParserDoubleClass = "package com.yeta.tophistory.parser;\n"+
            "\n"+
            "import com.yeta.tophistory.domain.HistoryPosition;\n"+
            "import com.yeta.tophistory.domain.HistoryRecord;\n"+
            "import org.jsoup.Jsoup;\n"+
            "import org.jsoup.nodes.Document;\n"+
            "import org.jsoup.nodes.Element;\n"+
            "import org.jsoup.select.Elements;\n"+
            "\n"+
            "import java.io.IOException;\n"+
            "import java.time.LocalDate;\n"+
            "import java.util.ArrayList;\n"+
            "import java.util.List;\n"+
            "\n"+
            "public class RottenTomatoesParserDouble implements AbstractParser {\n"+
            "\n"+
            "    public static final String ROTTEN_TOMATOES_TOP100_NAME = \"rottentomatoes_top100\";\n"+
            "    public static final String ROTTEN_TOMATOES_LINK = \"https://www.rottentomatoes.com/\";\n"+
            "    public static final String ROTTEN_TOMATOES_FIRST_TOP100_LINK = \"https://www.rottentomatoes.com/top/bestofrt/\";\n"+
            "\n"+
            "    @Override\n"+
            "    public HistoryRecord execute() {\n"+
            "        try {\n"+
            "            Document rottenTomatoesTop100page = Jsoup.connect(ROTTEN_TOMATOES_FIRST_TOP100_LINK).get();\n"+
            "            Elements top100rows = rottenTomatoesTop100page.\n"+
            "                select(\"div.panel-body.content_body.allow-overflow>table>tbody>tr>td:not([class])>a\");\n"+
            "            HistoryRecord historyRecord = new HistoryRecord();\n"+
            "            historyRecord.setTopName(ROTTEN_TOMATOES_TOP100_NAME);\n"+
            "            historyRecord.setDate(LocalDate.now());\n"+
            "            List<HistoryPosition> historyPositions = new ArrayList<>();\n"+
            "            for (int i = 0; i < top100rows.size(); i++) {\n"+
            "                HistoryPosition historyPosition = new HistoryPosition();\n"+
            "                Element a = top100rows.get(i);\n"+
            "                historyPosition.setPosition(i + 1);\n"+
            "                historyPosition.setName(a.text());\n"+
            "                historyPosition.setUrl(ROTTEN_TOMATOES_LINK + a.attr(\"href\"));\n"+
            "                historyPositions.add(historyPosition);\n"+
            "            }\n"+
            "            historyRecord.setHistoryPositions(historyPositions);\n"+
            "            return historyRecord;\n"+
            "        } catch (IOException e) {\n"+
            "            e.printStackTrace();\n"+
            "            throw new RuntimeException(e);\n"+
            "        }\n"+
            "    }\n"+
            "}\n";

    @Autowired
    ParserCompiler parserCompiler;

    @Test
    public void generate() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        AbstractParser parser = parserCompiler.generate(className, rottenTomatoesParserDoubleClass);
        HistoryRecord record = parser.execute();
        assertEquals(100, record.getHistoryPositions().size());
    }
}