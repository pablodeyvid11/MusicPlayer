package mpb.entities;

import java.io.Serializable;

public interface MPBEntity<T> extends Comparable<T>, Serializable {

	Long getId();

	void setId(Long id);
}
