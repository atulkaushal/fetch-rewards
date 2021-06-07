package com.github.atulkaushal.fetch.rewards.service;

import java.util.List;
import java.util.Map;

import com.github.atulkaushal.fetch.rewards.model.PayerInfo;

/**
 * The Interface PointsService.
 *
 * @author Atul
 */
public interface PointsService {

  /**
   * Adds the points.
   *
   * @param info the info
   * @return the list
   */
  public List<PayerInfo> addPoints(PayerInfo info);

  /**
   * Spend points.
   *
   * @param points the points
   * @return the map
   */
  public Map<String, Integer> spendPoints(int points);

  /**
   * Gets the balance points.
   *
   * @return the balance points
   */
  public Map<String, Integer> getBalancePoints();

  /**
   * Gets the history.
   *
   * @return the history
   */
  public List<PayerInfo> getHistory();
}
