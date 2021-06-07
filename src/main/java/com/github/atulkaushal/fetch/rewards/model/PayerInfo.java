package com.github.atulkaushal.fetch.rewards.model;

import java.time.LocalDateTime;

/**
 * The Class PayerInfo.
 *
 * @author Atul
 */
public class PayerInfo {

  /** The payer. */
  private String payer;

  /** The points. */
  private int points;

  /** The timestamp. */
  private LocalDateTime timestamp;

  /**
   * Instantiates a new payer info.
   *
   * @param payer the payer
   * @param points the points
   * @param localDateTime the timestamp
   */
  public PayerInfo(String payer, int points, LocalDateTime localDateTime) {
    this.payer = payer;
    this.points = points;
    this.timestamp = localDateTime;
  }

  /**
   * Gets the payer.
   *
   * @return the payer
   */
  public String getPayer() {
    return payer;
  }

  /**
   * Sets the payer.
   *
   * @param payer the new payer
   */
  public void setPayer(String payer) {
    this.payer = payer;
  }

  /**
   * Gets the points.
   *
   * @return the points
   */
  public int getPoints() {
    return points;
  }

  /**
   * Sets the points.
   *
   * @param points the new points
   */
  public void setPoints(int points) {
    this.points = points;
  }

  /**
   * Gets the timestamp.
   *
   * @return the timestamp
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the timestamp.
   *
   * @param timestamp the new timestamp
   */
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
