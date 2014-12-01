package bu.met.cs.cs673.pm.dao.unit;

import junit.framework.TestCase;

import org.junit.Test;

import bu.met.cs.cs673.pm.dao.MemberDAO;
import bu.met.cs.cs673.pm.dto.Member;

/**
 * MemberDAOTest
 * 
 * 
 * @author Luis Marion
 */
public class MemberDAOTest extends TestCase 
{

	private Member member;
	
	@Override
    protected void setUp() throws Exception
    {
        member = new Member();
        
        member.setProjectId(1);
        member.setUserId(1);
        member.setRoleName("member");
    }

	@Test
	public void testCreateMember()
	{
		MemberDAO dao = new MemberDAO();
		int success = dao.insertMember(member);
		
		System.out.println("success:" + success);
		
		assertTrue(success > 0);
		
		success = dao.deleteMember(member);
		assertTrue(success > 0);
	}
	

	@Test
	public void testGetMember()
	{
		Member searchMember = new Member();
		searchMember.setProjectId(1);
		searchMember.setUserId(2);
		
		MemberDAO dao = new MemberDAO();
		Member rMember = dao.getMember(searchMember);
		
		System.out.println("member: " + rMember.getRoleName());
		
		assertNotNull(rMember);
	}
}
