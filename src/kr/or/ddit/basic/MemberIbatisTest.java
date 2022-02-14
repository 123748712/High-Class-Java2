package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberIbatisTest {
	public static void main(String[] args) {

		// iBatis를 이용하여 DB데이터를 처리하는 작업 순서
		// 1. iBatis의 환경설정파일을 읽어와 실핸시킨다.
		
		try {
			// 1-1. xml문서 읽어오기
			// 설정파일의 인코딩 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성하기
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close(); // 스트림 객체 닫기
			
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			// 2-1. insert작업 연습
//			System.out.println("insert 작업 시작...");
//			
//			// 1) 저장할 데이터를 VO에 넣는다.
//			MemberVO mv = new MemberVO();
//			mv.setMemId("d002");
//			mv.setMemName("강감찬");
//			mv.setMemTel("010-2222-3333");
//			mv.setMemAddr("경남 김해시");
//			
//			// 2) SqlMapClient객체 변수를 이용하여 해당 쿼리문을 실행한다.
//			// 형식) smc.insert("namespace값.id값", 파라미터클래스객체) // 반환값 : 성공하면 'null' 반환
//			Object obj;
//				obj = smc.insert("memberTest.insertMember", mv);
//			
//			int cnt = smc.update("memberTest.insertMember", mv);
//			
//			if(cnt > 0) {
//				System.out.println("insert 작업 성공.");
//			} else {
//				System.out.println("insert 작업 실패.");
//			}
//			System.out.println("============================");
//			
//			
//			// 2-2 update작업 연습
//			System.out.println("update 작업 시작...");
//			
//			MemberVO mv2 = new MemberVO();
//			mv2.setMemId("d001");
//			mv2.setMemName("이순신");
//			mv2.setMemTel("010-1111-1111");
//			mv2.setMemAddr("대전시 중구 대흥동");
//			
//			// update()메서드의 반환값은 성공한 레크드 수 이다.
//			int cnt2 = smc.update("memberTest.updateMember", mv2);
//			
//			if(cnt2 > 0) {
//				System.out.println("update 작업 성공.");
//			} else {
//				System.out.println("update 작업 실패.");
//			}
//			System.out.println("============================");
//			
//			
//			// 2-3 delete작업 연습
//			System.out.println("delete 작업 시작...");
//			
//			// delete()메서드의 반환값 : 성공한 레코드 수
//			
//			int cnt3 = smc.delete("memberTest.deleteMember", "d001");
//			
//			if(cnt3 > 0) {
//				System.out.println("delete 작업 성공.");
//			} else {
//				System.out.println("delete 작업 실패.");
//			}
//			System.out.println("============================");
//			
//			// 2-4 select작업 연습
//			// 1) 응답결과가 여러개인 경우
//			System.out.println("select 연습 시작(결과가 여러개인 경우)");
//
//			// 응답 결과가 여러개일 경우에는 queryForList메서드를 사용한다.
//			// 이 메서드는 여거래의 레코드를 VO에 담은 후 이 VO 데이터를 List에 추가해 주는 작업을 자동으로 수행한다.
//			
//			List<MemberVO> memList = smc.queryForList("memberTest.getMemberAll");
//			for(MemberVO mem : memList) {
//				System.out.println("ID : " + mem.getMemId());
//				System.out.println("이름 : " + mem.getMemName());
//				System.out.println("전화번호 : " + mem.getMemTel());
//				System.out.println("주소 : " + mem.getMemAddr());
//				System.out.println("============================");
//			}
//			System.out.println("출력 끝...");
//			
			// 2. 응답이 1개일 경우
			System.out.println("select 연습 시작(결과가 1인 경우)");

//			// 응답결과가 1개가 확실한 경우에는 queryForObject메서드를 사용한다.
//			MemberVO mv3 = (MemberVO) smc.queryForObject("memberTest.getMember", "d002");
//			
//			System.out.println("ID : " + mv3.getMemId());
//			System.out.println("이름 : " + mv3.getMemName());
//			System.out.println("전화번호 : " + mv3.getMemTel());
//			System.out.println("주소 : " + mv3.getMemAddr());
//			System.out.println("============================");
			
			Map<String, String> memMap = (Map<String, String>) smc.queryForObject("memberTest.getMember", "d002");
			
			System.out.println("ID : " + memMap.get("MEM_ID"));
			System.out.println("이름 : " + memMap.get("MEM_NAME"));
			System.out.println("전화번호 : " + memMap.get("MEM_TEL"));
			System.out.println("주소 : " +memMap.get("MEM_ADDR"));
			System.out.println("============================");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
