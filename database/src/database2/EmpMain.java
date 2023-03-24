package database2;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		EmpDAO empDAO= new EmpDAO();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.println("=============");
			System.out.println("1. 사원정보 추가");
			System.out.println("2. 사원정보 삭제");
			System.out.println("3. 사원정보 수정");
			System.out.println("4. 사번 조회");
			System.out.println("5. 사원이룸 조회");
			System.out.println("6. 종료");
			System.out.println("=============");
			
			System.out.print("메뉴 입력 >> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				System.out.print("급여를 수정할 사원 번호 >> ");
				int empno = Integer.parseInt(sc.nextLine());
				System.out.print("수정할 급여 >> \n");
				int sal = Integer.parseInt(sc.nextLine());
				System.out.println(empDAO.update(sal, empno)?"급여 변경 완료":"급여 변경 실패");
				
				break;
			case 4:
				System.out.print("사원 번호 입력 >> ");
				empno = Integer.parseInt(sc.nextLine());
				EmpDTO dto = empDAO.getRow(empno);
//				System.out.println(dto);
				if(dto!=null) {
				System.out.println("\n====사원정보 조회======");
				System.out.println("사원번호 : "+dto.getEmpno());
				System.out.println("사원명 : "+dto.getEname());
				System.out.println("직무 : "+dto.getJob());
				System.out.println("급여 : "+dto.getSal());
				System.out.println("추가수당 : "+dto.getComm());
				System.out.println("부서번호 : "+dto.getDeptno());
				System.out.println();
				}else {
					System.out.println("사원번호를 확인해 주세요");
				}
				break;
			case 5:
				System.out.print("사원 이름 입력 >> ");
				String ename = sc.nextLine();
				
				//ArrayList가 빈상태 or 데이터가 담겨있는 상태
				ArrayList<EmpDTO> list = empDAO.getList(ename);
				System.out.println();
				
				
				if(list.isEmpty()) {
					System.out.println("사원이름을 확인해주세요");
				}else {
				System.out.println("사번\t사원명\t직무\t  입사일");
				System.out.println("=====================================");
				for (EmpDTO empDTO : list) {
					System.out.print(empDTO.getEmpno()+"\t");
					System.out.print(empDTO.getEname()+"\t");
					System.out.print(empDTO.getJob()+" ");
					System.out.print(empDTO.getHiredate()+"\n\n");
					}
				}
				break;
			case 6:
				flag = false;
				break;

			default:
				System.out.println("번호 다시 입력해 주세요");
				break;
			}
			
			
			
		}
		
	}
}