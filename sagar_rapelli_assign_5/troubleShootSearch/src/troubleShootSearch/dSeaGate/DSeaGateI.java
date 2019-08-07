package troubleShootSearch.dSeaGate;

import java.util.List;

import troubleShootSearch.visitor.Visitor;

/**
 * Interface for DSeaGate products
 * @author Sagar Rapelli
 *
 */
public interface DSeaGateI {
	public List<String> getTechSentence();
	public void accept(Visitor v);
}
