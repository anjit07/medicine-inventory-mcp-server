package medicine.mcp.server.service;

import medicine.mcp.server.model.Medicine;
import medicine.mcp.server.utils.MedicineDataLoader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineDataLoader medicineDataLoader;

    public MedicineService(MedicineDataLoader medicineDataLoader) {
        this.medicineDataLoader = medicineDataLoader;
    }

    public List<Medicine> getAllData(){
        return medicineDataLoader.getMedicines();
    }
}
