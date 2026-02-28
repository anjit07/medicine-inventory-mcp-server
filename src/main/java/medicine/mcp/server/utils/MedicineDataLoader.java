package medicine.mcp.server.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import medicine.mcp.server.model.Medicine;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineDataLoader {

    private List<Medicine>  medicines = new ArrayList<>();

    @PostConstruct
    void init(){
        loadData();
    }
    private void loadData()  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            InputStream inputStream = new ClassPathResource("data/medicines.json").getInputStream();
            medicines =
                    mapper.readValue(inputStream, new TypeReference<List<Medicine>>() {});
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load medicines", e);
        }
    }

    public List<Medicine> getMedicines(){
        return medicines;
    }
}
