//TESTE DE LEITURA DE ARQUIVOS CSV
package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransferidorCSVTest {

    @Test
    public void testReadCsvFile() throws IOException, CsvValidationException {

        CSVReader mockReader = mock(CSVReader.class);

        when(mockReader.readNext()).thenReturn(new String[]{"header1", "header2", "header3"}, new String[]{"data1", "data2", "data3"}, null);

        String[] headers = mockReader.readNext();
        String[] data = mockReader.readNext();

        assertArrayEquals(new String[]{"header1", "header2", "header3"}, headers);
        assertArrayEquals(new String[]{"data1", "data2", "data3"}, data);
    }
}
