package com.github.atulkaushal.fetch.rewards.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.atulkaushal.fetch.rewards.model.PayerInfo;
import com.github.atulkaushal.fetch.rewards.service.PointsService;

/**
 * The Class PointsService.
 *
 * @author Atul
 */
@Service
public class PointsServiceImpl implements PointsService{

  /** The list. */
  private List<PayerInfo> list = new ArrayList<PayerInfo>();

  /**
   * Adds the points.
   *
   * @param info the info
   * @return the list
   */
  public List<PayerInfo> addPoints(PayerInfo info) {
    if (info.getPoints() < 0) spendPoints(-1 * info.getPoints());
    else list.add(info);
    return list;
  }

  /**
   * Spend points.
   *
   * @param points the points
   * @return the map
   */
  public Map<String, Integer> spendPoints(int points) {
    Map<String, Integer> spendingMap = new LinkedHashMap<String, Integer>();
    if (points > 0) {
      list.sort((PayerInfo e1, PayerInfo e2) -> e1.getTimestamp().compareTo(e2.getTimestamp()));
      for (int i = 0; i < list.size(); i++) {
        if (points > 0) {
          int pointsUsed;
          PayerInfo pInfo = list.get(i);
          String payer = pInfo.getPayer();
          if (pInfo.getPoints() > 0) {
            if (pInfo.getPoints() >= points) {
              pInfo.setPoints(pInfo.getPoints() - points);
              list.set(i, pInfo);
              pointsUsed = points;
              points = 0;
            } else {
              int temp = points - pInfo.getPoints();
              points = temp;
              pointsUsed = pInfo.getPoints();
              pInfo.setPoints(0);
              list.set(i, pInfo);
            }
            addPayerToMap(spendingMap, payer, pointsUsed);
            if (points == 0) break;
          }
        }
      }
    }
    return spendingMap;
  }

  /**
   * Adds the payer to map.
   *
   * @param spendingMap the spending map
   * @param payer the payer
   * @param points the points
   * @return the int
   */
  private int addPayerToMap(Map<String, Integer> spendingMap, String payer, int points) {
    if (spendingMap.containsKey(payer)) {
      points = spendingMap.get(payer) - points;
    }
    spendingMap.put(payer, -1 * points);
    return points;
  }

  /**
   * Gets the balance points.
   *
   * @return the balance points
   */
  public Map<String, Integer> getBalancePoints() {
    Map<String, Integer> payerPointMap = new LinkedHashMap<String, Integer>();
    for (PayerInfo payerInfo : list) {
      String payer = payerInfo.getPayer();
      int points = 0;
      if (payerPointMap.containsKey(payer)) {
        points = payerPointMap.get(payer) + payerInfo.getPoints();
      } else {
        points = payerInfo.getPoints();
      }
      payerPointMap.put(payer, points);
    }
    return payerPointMap;
  }

  /**
   * Gets the history.
   *
   * @return the history
   */
  public List<PayerInfo> getHistory() {
    list.sort((PayerInfo e1, PayerInfo e2) -> e1.getTimestamp().compareTo(e2.getTimestamp()));
    return list;
  }
}
