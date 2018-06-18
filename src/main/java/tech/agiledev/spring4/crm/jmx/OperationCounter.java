package tech.agiledev.spring4.crm.jmx;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public class OperationCounter {
	private AtomicLong addAmount;
	private AtomicLong deleteAmount;

	public OperationCounter() {
		super();
		reset();
	}

	public void incrementAdd() {
		addAmount.getAndIncrement();
	}

	public void incrementDelete() {
		deleteAmount.getAndIncrement();
	}

	@ManagedAttribute
	public Long getAddAmount() {
		return addAmount.longValue();
	}

	@ManagedAttribute
	public Long getDeleteAmount() {
		return deleteAmount.longValue();
	}

	@ManagedOperation
	public void reset() {
		addAmount = new AtomicLong(0);
		deleteAmount = new AtomicLong(0);
	}
}
