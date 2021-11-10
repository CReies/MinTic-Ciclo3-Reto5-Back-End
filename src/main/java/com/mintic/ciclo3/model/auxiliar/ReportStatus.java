package com.mintic.ciclo3.model.auxiliar;

public class ReportStatus {
  private int completed;
  private int cancelled;

  public ReportStatus(int completed, int cancelled) {
    this.completed = completed;
    this.cancelled = cancelled;
  }

  public int getCompleted() {
    return completed;
  }

  public void setCompleted(int completed) {
    this.completed = completed;
  }

  public int getCancelled() {
    return cancelled;
  }

  public void setCancelled(int cancelled) {
    this.cancelled = cancelled;
  }

}
