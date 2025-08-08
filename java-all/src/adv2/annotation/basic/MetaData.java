package adv2.annotation.basic;

@AnnoMeta
public class MetaData {

    //@AnnoMeta // 필드에 적용 - 컴파일 오류
    private String id;

    @AnnoMeta
    public void call() {  }

    public static void main(String[] args) {
        AnnoMeta typeAnno = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("typeAnno = " + typeAnno);  // @adv2.annotation.basic.AnnoMeta()

        try {
            AnnoMeta methodAnno = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
            System.out.println("methodAnno = " + methodAnno);  // @adv2.annotation.basic.AnnoMeta()
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
            System.out.println("해당 애노테이션을 찾지 못했습니다.");
        }


    }

}
