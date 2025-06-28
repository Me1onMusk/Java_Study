package construct;

public class ConstructMain01 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("Kim", 20, 90);
        MemberConstruct member2 = new MemberConstruct("Lee", 30, 80);

        MemberConstruct[] members = {member1, member2};
        for(MemberConstruct m : members) {
            System.out.println("호출 name: " + m.name + " age: " + m.age + " grade: " + m.grade);
        }
    }
}
