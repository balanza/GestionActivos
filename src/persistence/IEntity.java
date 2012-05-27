package persistence;

public interface IEntity extends Comparable<IEntity> {

	public int getId();
	
	public String getLabel();
	
}
