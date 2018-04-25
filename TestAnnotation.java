import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //on class level
@interface Annot {
	String createdBy() default "Mkyong";
	String lastModified() default "03/01/2014";
}
class AnnoteObject{
	private String created,modified;
	AnnoteObject(String createdby,String lastmodified){
		created=createdby;
		modified=lastmodified;
	}
	public  void getDetails() {
		System.out.println("Object Created By: " +created +"\n"+ "Modified By: " + modified);
	}
}
class AnnoteAccess {
	@Annot(createdBy="Deep",lastModified="4/24/2018")
	static AnnoteObject annote1;
	@Annot(createdBy="Jeet",lastModified="4/14/2018")
	static AnnoteObject annoteOther;
	public void showDetails() {
		annote1.getDetails();
		annoteOther.getDetails();
		annote1.getDetails();
	}
}
public class TestAnnotation {
	
	public  AnnoteAccess initiate(Object annoteClass) {
		AnnoteAccess ann=new AnnoteAccess();
		Class<AnnoteAccess> objAnnote = AnnoteAccess.class;
		for(Field field:objAnnote.getDeclaredFields()) {
			Class type = field.getType();
			String name = field.getName();
			Annot annVal=field.getDeclaredAnnotation(Annot.class);
			//System.out.println(type.toString() +"\t"+ name+ "\t");
			if(annVal!=null) {
				AnnoteObject obj=new AnnoteObject(annVal.createdBy(),annVal.lastModified());
				try {
					field.set(ann, obj);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(annVal.createdBy());
				//System.out.println(annVal.lastModified());
			}
		}
		return ann;
	}
	
	public static void main(String args[]) {
		TestAnnotation tann=new TestAnnotation();
		AnnoteAccess testann=tann.initiate(AnnoteAccess.class);
		//testann.showDetails();
		AnnoteAccess.annote1.getDetails();
		AnnoteAccess.annoteOther.getDetails();
		
	}
}
