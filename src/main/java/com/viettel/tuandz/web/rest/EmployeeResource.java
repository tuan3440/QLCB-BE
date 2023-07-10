package com.viettel.tuandz.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.viettel.tuandz.config.Constants;
import com.viettel.tuandz.service.EmployeeService;
import com.viettel.tuandz.service.FileAttachmentService;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import com.viettel.tuandz.utils.FileUtil;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FileAttachmentService fileAttachmentService;

    @Autowired
    private Environment environment;

    @Autowired
    private Gson gson;

    @PostMapping("insert")
    public ResponseEntity<EmployeeDTO> insert(
        @RequestParam(value = "employeeDTOString") String employeeDTOString,
        @RequestParam(value = "imgAsset") MultipartFile imgAsset
    ) {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(
                Instant.class,
                (JsonDeserializer<Instant>) (json, type, ctx) -> Instant.parse(json.getAsJsonPrimitive().getAsString())
            )
            .create();
        EmployeeDTO employeeDTO = gson.fromJson(employeeDTOString, EmployeeDTO.class);
        EmployeeDTO result = employeeService.save(employeeDTO);
        Long fileAttachmentId = FileUtil.save(imgAsset, result.getId(), Constants.FILE_TYPE.AVATAR, environment, fileAttachmentService);
        result.setAvatarId(fileAttachmentId);
        EmployeeDTO result2 = employeeService.save(result);
        return ResponseEntity.ok(result2);
    }

    @PostMapping("update")
    public ResponseEntity<EmployeeDTO> update(
        @RequestParam(value = "employeeDTOString") String employeeDTOString,
        @RequestParam(value = "imgAsset", required = false) MultipartFile imgAsset,
        @RequestParam(value = "imgAssetDel", required = false) String imgAssetDel
    ) {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(
                Instant.class,
                (JsonDeserializer<Instant>) (json, type, ctx) -> Instant.parse(json.getAsJsonPrimitive().getAsString())
            )
            .create();
        EmployeeDTO employeeDTO = gson.fromJson(employeeDTOString, EmployeeDTO.class);
        Long employeeId = employeeDTO.getId();
        EmployeeDTO employeeDTOCurrent = employeeService.findById(employeeId);
        employeeDTO.setAvatarId(employeeDTOCurrent.getAvatarId());
        if (imgAsset != null) {
            Long fileAttachmentId = FileUtil.save(imgAsset, employeeId, Constants.FILE_TYPE.AVATAR, environment, fileAttachmentService);
            employeeDTO.setAvatarId(fileAttachmentId);
        }
        if (imgAssetDel != null) {
            fileAttachmentService.deleteById(Long.valueOf(imgAssetDel));
        }
        employeeDTO = employeeService.save(employeeDTO);
        return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping("doSearch")
    public ResponseEntity<List<EmployeeDTO>> doSearch(@RequestBody EmployeeDTO employeeDTO) {
        List<EmployeeDTO> res = employeeService.doSearch(employeeDTO);
        return ResponseEntity.ok(res);
    }

    @PostMapping("find/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable("id") Long id) {
        EmployeeDTO res = employeeService.findById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        if (employeeDTO != null) {
            if (employeeDTO.getAvatarId() != null) {
                fileAttachmentService.deleteById(employeeDTO.getAvatarId());
            }
            employeeService.delete(id);
        }
        return ResponseEntity.noContent().build();
    }
}
