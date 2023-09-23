//
//  ContentView.swift
//  iosApp
//
//  Created by Denis Sychev on 24.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.all, edges: .bottom) // Compose has own keyboard handler
    }
}
