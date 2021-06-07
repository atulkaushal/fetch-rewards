package com.github.atulkaushal.fetch.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.atulkaushal.fetch.rewards.model.PayerInfo;
import com.github.atulkaushal.fetch.rewards.service.PointsService;

/**
 * The Class PointServiceController.
 *
 * @author Atul
 */
@RestController()
public class PointsController {

  /** The point service. */
  @Autowired PointsService pointService;

  /**
   * Adds the transaction.
   *
   * @param payer the payer
   * @return the response entity
   */
  @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPoints(@RequestBody PayerInfo payer) {
    pointService.addPoints(payer);
    return new ResponseEntity<>(payer.getPayer() + ":" + payer.getPoints(), HttpStatus.OK);
  }

  /**
   * Spend points.
   *
   * @param payer the payer
   * @return the response entity
   */
  @PostMapping(path = "/spend", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> spendPoints(@RequestBody PayerInfo payer) {
    return new ResponseEntity<>(pointService.spendPoints(payer.getPoints()), HttpStatus.OK);
  }

  /**
   * Balance points.
   *
   * @return the response entity
   */
  @GetMapping("/balance")
  public ResponseEntity<?> balancePoints() {
    return new ResponseEntity<>(pointService.getBalancePoints(), HttpStatus.OK);
  }

  /**
   * History.
   *
   * @return the response entity
   */
  @GetMapping("/history")
  public ResponseEntity<?> history() {
    return new ResponseEntity<>(pointService.getHistory(), HttpStatus.OK);
  }
}
