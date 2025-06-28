package construct;

public class MethodInitMain03 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.initMember("Kim", 20, 90);

        MemberInit member2 = new MemberInit();
        member2.initMember("Lee", 30, 80);

        MemberInit[] members = {member1, member2};

        for(MemberInit m : members) {
            System.out.println("이름: " + m.name + " 나이: " + m.age + " 성적: " + m.grade);
        }
    }
}
