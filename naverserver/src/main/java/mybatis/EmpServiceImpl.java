package mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao ;

	@Override
	public List<EmpVO> getEmpList() {
		return dao.emplist();
	}

/*	@Override
	public EmpVO getEmpOne(int id) {
		return dao.getEmpOne(id);
	}

	@Override
	public void insertEmp(EmpVO vo) {
		EmpVO RESULT = dao.getEmpOne(vo.getEmployee_id());
		if(RESULT == null) { 		dao.insertEmp(vo); }
		
	}

	@Override
	public void updateEmp(EmpVO vo) {
		dao.updateEmp(vo);
		
	}

	@Override
	public void deleteEmp(String name) {
		name = "%" + name + "%";
		dao.deleteEmp(name);
		
	}

	@Override
	public int countEmp() {
		return dao.countEmp();
	}

	@Override
	public List<EmpVO> empDeptList(int[] a) {
		return dao.empDeptList(a);
	}
	
	*/

}
