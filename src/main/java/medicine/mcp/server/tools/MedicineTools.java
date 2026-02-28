package medicine.mcp.server.tools;

import medicine.mcp.server.model.Medicine;
import medicine.mcp.server.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MedicineTools {

    Logger logger = LoggerFactory.getLogger(MedicineTools.class);

    private final MedicineService medicineService;

    public MedicineTools(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @McpTool(name = "list_medicines", description = "Get all medicines")
    public List<Medicine> listMedicines() {

        logger.info("list_medicines tools.");
        return medicineService.getAllData();
    }

    @McpTool(name = "low_stock_medicines",
            description = "Find low stock medicines"
    )
    public List<Medicine> lowStockMedicines(@McpToolParam(description = "quantity" ,required = false) Integer quantity) {

        logger.info("low_stock_medicines tools quantity {}",quantity);
        int qnt=quantity!=null?quantity:200;
        return medicineService.getAllData()
                .stream()
                .filter(m -> m.getQuantity() < qnt)
                .toList();

    }

    @McpTool(
            name = "expiring_medicines",
            description = "" +
                    ""
    )
    public List<Medicine> expiringMedicines(@McpToolParam(description = "expiring" ,required = false) Integer expiring) {

        logger.info("expiring_medicines tools expiring {}",expiring);
        int expry=expiring!=null?expiring:2;
        LocalDate sixMonths = LocalDate.now().plusMonths(expry);
        return medicineService.getAllData()
                .stream()
                .filter(m -> m.getExpiryDate().isBefore(sixMonths))
                .toList();

    }
    @McpTool(
            name = "get_medicine_stock",
            description = "Get stock of medicine"
    )
    public Medicine getMedicineStock(@McpToolParam(description = "medicineName") String medicineName) {

        logger.info("get_medicine_stock tools medicineName {}",medicineName);
        return medicineService.getAllData()
                .stream()
                .filter(m -> m.getName().equalsIgnoreCase(medicineName))
                .findFirst()
                .orElse(null);

    }

    @McpTool(
            name = "inventory_summary",
            description = "Get inventory summary"
    )
    public String summary() {


        int totalMedicines =  medicineService.getAllData().size();
        int totalQty =  medicineService.getAllData()
                .stream()
                .mapToInt(Medicine::getQuantity)
                .sum();

        logger.info("inventory_summary tools totalMedicines {} and totalQty {}",totalMedicines,totalQty);

        return "Total Medicines: " + totalMedicines +
                ", Total Quantity: " + totalQty;

    }
}
