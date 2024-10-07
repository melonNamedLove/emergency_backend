package daelim.emergency_backend.database

import daelim.emergency_backend.database.emergencyHospital.EmergencyHospitalData
import daelim.emergency_backend.database.emergencyHospital.EmergencyRepository
import daelim.emergency_backend.database.hospitalInformation.HospitalInformation
import daelim.emergency_backend.database.hospitalInformation.HospitalRepository
import org.springframework.stereotype.Service

@Service
class EmergencyService(val emergencyRepository: EmergencyRepository, val hospitalRepository: HospitalRepository) {

    fun test(id: String) : EmergencyHospitalData? {
        return emergencyRepository.findById(id).orElse(null)
    }

    fun testHospital(id: String) : HospitalInformation? {
        return hospitalRepository.findById(id).orElse(null)
    }

    fun searchWithCity(stage1:String, stage2:String) : List<HospitalInformation> {

        return hospitalRepository.findByAddress(stage1,stage2);
    }

    //hospital information List 반환 서비스
    fun getHospitalInformationsByPage(page:String?): List<HospitalInformation>{
        return hospitalRepository.getHospitalInformationsByPageQuery(page);
    }
}