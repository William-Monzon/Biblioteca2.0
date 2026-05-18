package models.loans;

import java.time.LocalDate;

import models.book.Material;
import models.user.User;

public class Loans {
	private final int id;
	private final Material material;
	private final User user;
	private final LocalDate dateLoans;
	private final LocalDate deadline;
	private LocalDate dateDelivery;

	public Loans(int id, Material material, User user, LocalDate dateLoans, LocalDate deadline,
			LocalDate dateDelivery) {
		super();
		this.id = id;
		this.material = material;
		this.user = user;
		this.dateLoans = LocalDate.now();
		this.deadline = dateLoans.plusDays(material.dayLoans());
		this.dateDelivery = dateDelivery;
	}

	public LocalDate getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(LocalDate dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public int getId() {
		return id;
	}

	public Material getMaterial() {
		return material;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getDateLoans() {
		return dateLoans;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public boolean isOverdue() {
		return dateDelivery == null && LocalDate.now().isAfter(deadline);
	}

	public double calculateFine() {
		if (!isOverdue()) {
			return 0;
		} else {
			return material.calculateFine();
		}
	}

	public void returned() {
		this.dateDelivery = LocalDate.now();
	}

	public boolean isActive() {
		return dateDelivery == null;
	}

}
