/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class NetworkTableListener {

    // Define a network table and create entrys for each value
    NetworkTable table;
    NetworkTableEntry positionEntry;
    NetworkTableEntry leftTapeEntry;
    NetworkTableEntry rightTapeEntry;

    public double[] responseTable = new double[3];  // Public array to store the results from network table exchange
    
    NetworkTableListener(String table_name) {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        table = inst.getTable(table_name);
        positionEntry = table.getEntry("offset");
        leftTapeEntry = table.getEntry("leftDistance");
        rightTapeEntry = table.getEntry("rightDistance");
    }

    public void createListeners() {
        
        positionEntry.addListener(event -> {
            responseTable[0] = (double) event.value.getValue();
        }, EntryListenerFlags.kUpdate);

        leftTapeEntry.addListener(event -> {
            responseTable[1] = (double) event.value.getValue();
        }, EntryListenerFlags.kUpdate);

        rightTapeEntry.addListener(event -> {
            responseTable[2] = (double) event.value.getValue();
        }, EntryListenerFlags.kUpdate);

    }

}
